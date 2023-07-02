package com.codegym.vn.formlogin.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "job")
public class Job {

    @Id
    Integer jobCode;

    String jobName;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private Set<Infor> infors;

    public Integer getJobCode() {
        return jobCode;
    }

    public void setJobCode(Integer jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

}
