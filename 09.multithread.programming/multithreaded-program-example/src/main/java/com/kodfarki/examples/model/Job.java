package com.kodfarki.examples.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB")
public class Job {

    private long Id;
    private int control;
    private int jobType;
    private Date creationDate;
    private Date modificationDate;
    private int version;

    public Job(int control, int jobType, Date creationDate, Date modificationDate, int version) {
        this.control = control;
        this.jobType = jobType;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.version = version;
    }

    public Job() {
    }

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "JOB_DEFAULT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Column(name = "CONTROL")
    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    @Column(name = "JOB_TYPE")
    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "MODIFICATION_DATE")
    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Job{" +
                "Id=" + Id +
                ", control=" + control +
                ", jobType=" + jobType +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", version=" + version +
                '}' + "\n";
    }
}
