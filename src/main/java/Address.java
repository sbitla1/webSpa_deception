public class Address {

    private  String addresses;
    private String UniqueIds;
    private String addressToMatch;
    private String beds;
    private String matches;

    public Address() {
    }

    public String getAddresses() {
        return addresses;
    }

    public Address(String addresses, String uniqueIds, String addressToMatch, String beds, String matches) {
        this.addresses = addresses;
        UniqueIds = uniqueIds;
        this.addressToMatch = addressToMatch;
        this.beds = beds;
        this.matches = matches;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getUniqueIds() {
        return UniqueIds;
    }

    public void setUniqueIds(String uniqueIds) {
        UniqueIds = uniqueIds;
    }

    public String getAddressToMatch() {
        return addressToMatch;
    }

    public void setAddressToMatch(String addressToMatch) {
        this.addressToMatch = addressToMatch;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }


}
