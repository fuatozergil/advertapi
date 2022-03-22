package com.poc.ilanapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Advert")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "header")
    @Size(min = 10, max = 50)
    private String header;

    @Size(min = 20, max = 200)
    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;
    
    @OneToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    
    @Column(name = "Active")
    private int active;
    
    @Column(name = "Duplicate")
    private int duplicate;
    
    @Column(name = "Updater")
    private int updater;
    
    @Version
    @Column(name = "VERSION")
    private long version;


    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date creationDate;
    
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modify_date")
    private Date modifyDate;

   
}
