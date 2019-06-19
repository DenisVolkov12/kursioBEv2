package ru.kursio.application.model.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kursio.application.model.entity.course.Course;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "name")
	@NotEmpty
	private String name;
	@Column(name = "last_name")
	@NotEmpty
	private String lastName;
	@Column(name = "email", unique=true, nullable=false)
	@Email(message="Invalid email, check if it has @ and domain")
	@NotEmpty
	private String email;
	@Column(name = "user_name", unique=true, nullable=false)
	@NotEmpty
	private String userName;
	@Column(name = "password")
	private String password;
	@Lob
	@Column(name = "about_me")
	private String aboutMe;
	@Column(name = "designation")
	private String designation;
	@Column(name = "avatar")
	private String avatar;
	@Column(name="rating_average")
	private double ratingAverage;
	@Column(name = "active")
	@JsonProperty
	private boolean active;
	@Column(name = "instagram_url")
	private String instagramUrl;
	@Column(name = "facebook_url")
	private String facebookUrl;
	@Column(name = "linkedin_url")
	private String linkedInUrl;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToMany(mappedBy="user")
	private List<Course> createdCourses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> userCourses;

	@Column(name="is_teacher")
    private boolean isTeacher;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@JsonIgnore
	public boolean isActive() {
		return active;
	}

	@JsonProperty
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@JsonIgnore
	public List<Course> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(List<Course> userCourses) {
		this.userCourses = userCourses;
	}

	@JsonIgnore
	public List<Course> getCreatedCourses() {
		return createdCourses;
	}

	public void setCreatedCourses(List<Course> createdCourses) {
		this.createdCourses = createdCourses;
	}

	public double getRatingAverage() {
		return ratingAverage;
	}

	public void setRatingAverage(double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
