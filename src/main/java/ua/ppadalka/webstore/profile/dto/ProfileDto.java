package ua.ppadalka.webstore.profile.dto;

public class ProfileDto {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public ProfileDto() {}

    public static ProfileDtoBuilder builder() {
        return new ProfileDtoBuilder();
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

    public static class ProfileDtoBuilder {
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;

        private ProfileDtoBuilder() {}

        public ProfileDto build() {
            ProfileDto dto = new ProfileDto();

            dto.firstName = firstName;
            dto.lastName = lastName;
            dto.address = address;
            dto.phoneNumber = phoneNumber;

            return dto;
        }

        public ProfileDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProfileDtoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProfileDtoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public ProfileDtoBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }
}
