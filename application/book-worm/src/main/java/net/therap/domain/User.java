package net.therap.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/4/14.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "firstName")
    @NotNull
    @NotEmpty(message = "First Name Must Not be empty")
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    @NotEmpty(message = "Last Name Must Not be empty")
    private String lastName;

    @Column(name = "email", unique = true)
    @NotNull
    @NotEmpty(message = "Email Must Not be empty")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Invalid email address.")
    private String email;

    @Column(name = "password")
    @NotNull
    @NotEmpty(message = "Password  Must Not be empty")
    @Size(min = 5, max = 128, message = "Password too small. Minimum length 5")
    private String password;

    @Transient
    private String retypedPassword;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    private Area area;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @NotNull
    @Column(name = "reputation_point")
    private double reputationPoint = 0.0;

    @NotNull
    @Column(name = "reviewer_count")
    private int reviewerCount = 0;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Notification> sentNotification;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WishedBook> wishedBooks;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Book> postedBooks;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public double getReputationPoint() {
        return reputationPoint;
    }

    public void setReputationPoint(double reputationPoint) {
        this.reputationPoint = reputationPoint;
    }

    public int getReviewerCount() {
        return reviewerCount;
    }

    public void setReviewerCount(int reviewerCount) {
        this.reviewerCount = reviewerCount;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Notification> getSentNotification() {
        return sentNotification;
    }

    public void setSentNotification(Set<Notification> sentNotification) {
        this.sentNotification = sentNotification;
    }

    public Set<WishedBook> getWishedBooks() {
        return wishedBooks;
    }

    public void setWishedBooks(Set<WishedBook> wishedBooks) {
        this.wishedBooks = wishedBooks;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public Set<Book> getPostedBooks() {
        return postedBooks;
    }

    public void setPostedBooks(Set<Book> postedBooks) {
        this.postedBooks = postedBooks;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", retypedPassword='" + retypedPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", area=" + area +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", reputationPoint=" + reputationPoint +
                ", notifications=" + notifications +
                ", wishedBooks=" + wishedBooks +
                ", postedBooks=" + postedBooks +
                '}';
    }

}
