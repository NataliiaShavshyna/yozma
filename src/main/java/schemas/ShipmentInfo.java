package schemas;

import utils.StringGenerator;

import java.util.Objects;

/**
 * The type Shipment info.
 */
public class ShipmentInfo {
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String region;
    private String state;
    private String city;
    private String postalCode;
    private String phoneNumber;

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     * @return the email
     */
    public ShipmentInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     * @return the first name
     */
    public ShipmentInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     * @return the last name
     */
    public ShipmentInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     * @return the street
     */
    public ShipmentInfo setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     * @return the region
     */
    public ShipmentInfo setRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     * @return the state
     */
    public ShipmentInfo setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     * @return the city
     */
    public ShipmentInfo setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     * @return the postal code
     */
    public ShipmentInfo setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     * @return the phone number
     */
    public ShipmentInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentInfo that = (ShipmentInfo) o;
        return Objects.equals(email, that.email)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(street, that.street)
                && Objects.equals(region, that.region)
                && Objects.equals(state, that.state)
                && Objects.equals(city, that.city)
                && Objects.equals(postalCode, that.postalCode)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, street, region, state, city, postalCode, phoneNumber);
    }
}
