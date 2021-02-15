package timetracker.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id")
    private Activity activity;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_request_id")
    private UserRequest userRequest;
    @Column(name = "time")
    private String time;
    @Column(name = "time_start")
    private Long timeStart;
    @Column(name = "time_stop")
    private Long timeStop;
    @Column(name = "difference_time")
    private Long differenceTime;
    @Column(name = "time_switch")
    private Boolean timeSwitch;
}
