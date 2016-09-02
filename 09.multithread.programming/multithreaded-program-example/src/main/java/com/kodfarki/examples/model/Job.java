package com.kodfarki.examples.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Version;
import java.util.Date;

@Entity
@Table(name = "JOB")
public class Job {

    private long id;
    private int status;
    private int jobType;
    private Date creationDate;
    private Date modificationDate;
    private int version;

    public Job(int jobType, Date creationDate, Date modificationDate) {
        this.status = 0;
        this.jobType = jobType;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Job(){
    }

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "JOB_DEFAULT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
                "Id=" + id +
                ", control=" + status +
                ", jobType=" + jobType +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", version=" + version +
                '}' + "\n";
    }
}
