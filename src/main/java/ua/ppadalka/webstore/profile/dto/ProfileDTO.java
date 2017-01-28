package ua.ppadalka.webstore.profile.dto;

public class ProfileDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public ProfileDTO() {}

    public static ProfileDTOBuilder builder() {
        return new ProfileDTOBuilder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static class ProfileDTOBuilder {
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;

        private ProfileDTOBuilder() {}

        public ProfileDTO build() {
            ProfileDTO dto = new ProfileDTO();

            dto.firstName = firstName;
            dto.lastName = lastName;
            dto.address = address;
            dto.phoneNumber = phoneNumber;

            return dto;
        }

        public ProfileDTOBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProfileDTOBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProfileDTOBuilder address(String address) {
            this.address = address;
            return this;
        }

        public ProfileDTOBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }
}
