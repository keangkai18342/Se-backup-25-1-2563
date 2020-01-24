package se.g21.backend.coursesystem.entities;

import lombok.*;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
// import java.util.Date;
import java.time.LocalTime;
// import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name="Time")
public class Time {
	@Id
	@SequenceGenerator(name="Time_seq",sequenceName="Time_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Time_seq")
	@Column(name="Time_ID",unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String day;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    private @NonNull LocalTime start_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    private @NonNull LocalTime end_time;

	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Course> course;
}