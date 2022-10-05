package es.travelworld.traveling.models;

public class Hotel {
    private long id;
    private String name;
    private long starRating;
    private Address address;
    private RatePlan ratePlan;
    private OptimizedThumbUrls optimizedThumbUrls;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public long getStarRating() {
        return starRating;
    }

    public void setStarRating(long value) {
        this.starRating = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = value;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan value) {
        this.ratePlan = value;
    }

    public OptimizedThumbUrls getOptimizedThumbUrls() {
        return optimizedThumbUrls;
    }

    public void setOptimizedThumbUrls(OptimizedThumbUrls value) {
        this.optimizedThumbUrls = value;
    }
}

