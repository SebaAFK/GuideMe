

package com.mycompany.guidemeproject;

// GuideMe.java
import java.util.*;

// Superclass: TravelService
abstract class TravelService {
    protected String serviceName;
    protected String serviceDetails;

    public TravelService(String serviceName, String serviceDetails) {
        this.serviceName = serviceName;
        this.serviceDetails = serviceDetails;
    }

    public abstract void displayServiceDetails();
}

// Subclass: City
class City extends TravelService {
    String country;
    String currency;
    double exchangeRate;
    Hotel[] hotels;
    Restaurant[] restaurants;
    Flight[] flights;

    public City(String name, String country, String currency, double exchangeRate, Hotel[] hotels, Restaurant[] restaurants, Flight[] flights) {
        super(name, "City Travel Services");
        this.country = country;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.hotels = hotels;
        this.restaurants = restaurants;
        this.flights = flights;
    }

    public void displayServiceDetails() {
        System.out.println("Welcome to " + serviceName + ", " + country);
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
    
    public String getCurrency() {
        return currency;
    }

    public void getFlights() {
        System.out.println("Flights to " + serviceName + ":");
        for (int i = 0; i < flights.length; i++) {
            System.out.println((i + 1) + "- " + flights[i].getAirline());
        }
    }

    public void getHotels() {
        System.out.println("Available Hotels:");
        for (int i = 0; i < hotels.length; i++) {
            System.out.println((i + 1) + "- " + hotels[i].getHotelName());
        }
    }

    public void getRestaurants() {
        System.out.println("Available Restaurants:");
        for (int i = 0; i < restaurants.length; i++) {
            System.out.println((i + 1) + "- " + restaurants[i].getRestaurantName());
        }
    }
}

// Subclass: Hotel
class Hotel extends TravelService {
    private int rating;

    public Hotel(String name, int rating) {
        super(name, "Hotel");
        this.rating = rating;
    }

    public void displayServiceDetails() {
        System.out.println("Hotel: " + serviceName + " | Rating: " + rating + " stars");
    }
    
    public String getHotelName() {
        return serviceName;
    }
}

// Subclass: Restaurant
class Restaurant extends TravelService {
    public Restaurant(String name) {
        super(name, "Restaurant");
    }

    public void displayServiceDetails() {
        System.out.println("Restaurant: " + serviceName);
    }
    
    public String getRestaurantName() {
        return serviceName;
    }
}

// Subclass: Flight
class Flight extends TravelService {
    private String airline;

    public Flight(String airline) {
        super(airline, "Flight Service");
        this.airline = airline;
    }

    public void displayServiceDetails() {
        System.out.println("Flight with " + airline);
    }
    
    public String getAirline() {
        return airline;
    }
}

// Main Class
public class GuideMeProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        City[] cities = {
            new City("Rome", "Italy", "EUR", 0.25,
                new Hotel[]{ new Hotel("Four Seasons Hotel", 5), new Hotel("Hilton Hotel", 4) },
                new Restaurant[]{ new Restaurant("Armando al Pantheon"), new Restaurant("Roscioli Salumeria con"), new Restaurant("Cantina e Cucina"), new Restaurant("La Traverna dei Fori Imperiali") },
                new Flight[]{ new Flight("Saudi Airway"), new Flight("Qatar Airway"), new Flight("Emirate Airway"), new Flight("Turkish Airway") }
            ),
            new City("London", "UK", "GBP", 0.21,
                new Hotel[]{ new Hotel("Marriott Hotel", 4), new Hotel("Hampton Inn Hotel", 3) },
                new Restaurant[]{ new Restaurant("Nina"), new Restaurant("The Ivy Asia"), new Restaurant("Tom's Pasta"), new Restaurant("Balthazar") },
                new Flight[]{ new Flight("Saudi Airway"), new Flight("Qatar Airway"), new Flight("Emirate Airway"), new Flight("Turkish Airway") }
            ),
            new City("Paris", "France", "EUR", 0.24,
                new Hotel[]{ new Hotel("Four Seasons Hotel", 5), new Hotel("Hilton Hotel", 4) },
                new Restaurant[]{ new Restaurant("Les Deux Magots"), new Restaurant("Under the Sea"), new Restaurant("La Promenade"), new Restaurant("Pardi") },
                new Flight[]{ new Flight("Saudi Airway"), new Flight("Qatar Airway"), new Flight("Emirate Airway"), new Flight("Turkish Airway") }
            ),
            new City("New York", "USA", "USD", 0.27,
                new Hotel[]{ new Hotel("Marriott Hotel", 4), new Hotel("Hampton Inn Hotel", 3) },
                new Restaurant[]{ new Restaurant("Manhatta"), new Restaurant("Lillie's Victorian"), new Restaurant("Match 65"), new Restaurant("Fire Grill") },
                new Flight[]{ new Flight("Saudi Airway"), new Flight("Qatar Airway"), new Flight("Emirate Airway"), new Flight("Turkish Airway") }
            )
        };

        System.out.println("Choose your city:");
        for (int i = 0; i < cities.length; i++) {
            System.out.println((i + 1) + "- " + cities[i].serviceName);
        }
        int cityChoice = scanner.nextInt() - 1;
        City chosenCity = cities[cityChoice];

        System.out.println("1 SAR equals " + chosenCity.getExchangeRate() + " " + chosenCity.getCurrency());
        System.out.println("Enter amount to convert (or 0 to skip):");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            System.out.println(amount + " SAR = " + (amount * chosenCity.getExchangeRate()) + " " + chosenCity.getCurrency());
        }

        chosenCity.getFlights();
        int flightChoice = scanner.nextInt() - 1;
        chosenCity.getHotels();
        int hotelChoice = scanner.nextInt() - 1;
        chosenCity.getRestaurants();
        int restaurantChoice = scanner.nextInt() - 1;

        System.out.println("You chose: " + chosenCity.serviceName + ", " + chosenCity.getCurrency() + ", " + chosenCity.flights[flightChoice].getAirline() + ", " + chosenCity.hotels[hotelChoice].getHotelName() + ", " + chosenCity.restaurants[restaurantChoice].getRestaurantName());
    }
}
