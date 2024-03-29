package com.estate.real_estate.domain;
// Generated Aug 30, 2018 1:31:48 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Feedback generated by hbm2java
 */
@Entity
@Table(name="feedback"
    ,catalog="db_estate"
)
public class Feedback  implements java.io.Serializable {


     private Integer feedId;
     private User user;
     private String feedTitle;
     private String feedDes;
     private Date feedDate;
     private Inquiry inquiry;

    public Feedback() {
    }

    public Feedback(User user, String feedTitle, String feedDes, Date feedDate, Inquiry inquiry) {
       this.user = user;
       this.feedTitle = feedTitle;
       this.feedDes = feedDes;
       this.feedDate = feedDate;
       this.inquiry = inquiry;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="feed_id", unique=true, nullable=false)
    public Integer getFeedId() {
        return this.feedId;
    }
    
    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="feed_title", nullable=false, length=20)
    public String getFeedTitle() {
        return this.feedTitle;
    }
    
    public void setFeedTitle(String feedTitle) {
        this.feedTitle = feedTitle;
    }

    
    @Column(name="feed_des", nullable=false, length=90)
    public String getFeedDes() {
        return this.feedDes;
    }
    
    public void setFeedDes(String feedDes) {
        this.feedDes = feedDes;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="feed_date", nullable=false, length=10)
    public Date getFeedDate() {
        return this.feedDate;
    }
    
    public void setFeedDate(Date feedDate) {
        this.feedDate = feedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inq_id", nullable=false)
    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }




}


