package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor

public class Abo implements IAbo{
    AbonnementRepository ar;
    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return ar.getSubscriptionByType(type);
    }

    @Override
    public Set<Abonnement> retrieveSubscriptionsByDates(Date date1, Date date2) {
        return ar.findAbonnementByDateDebutBetween(date1,date2);
    }
    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void retrieveSubscriptions() {

        Set<Abonnement> expiringSubscriptions = getExpiringSubscriptions();

        for (Abonnement subscription : expiringSubscriptions) {
            Skieur skieur = subscription.getSkieur();

            System.out.println("Subscription Expiring Soon:");
            System.out.println("Subscription Number: " + subscription.getNumAbo());
            System.out.println("Skieur Number: " + skieur.getNumSkieur());
            System.out.println("Skieur Name: " + skieur.getNomS() + " " + skieur.getPrenomS());
            System.out.println("-------------------------");
        }
    }
    public Set <Abonnement> getExpiringSubscriptions() {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        calendar.add(Calendar.DAY_OF_MONTH, 7);

        Date expirationDate = calendar.getTime();

        return ar.findAbonnementByDateDebutBetween(currentDate, expirationDate);
    }

    @Scheduled(cron = "0 0 0 1 * ?") // Run at midnight on the first day of each month
    public void showMonthlyRecurringRevenue() {
        double totalMRR = calculateTotalMRR();
        System.out.println("Monthly Recurring Revenue (MRR): $" + totalMRR);
    }

    private double calculateTotalMRR() {

        return ar.findActiveSubscriptions()
                .stream()
                .mapToDouble(subscription -> subscription.getPrixAbon())
                .sum();
    }
}
