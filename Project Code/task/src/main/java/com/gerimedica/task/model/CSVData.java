package com.gerimedica.task.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="tbl_CSV_data" ,uniqueConstraints=@UniqueConstraint(columnNames="code"))
public class CSVData {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 100 ,nullable = false)
    private  String  source;
    @Column(length = 100 ,nullable = false)
    private String codeListCode;
    @Column(unique=true ,length =100 ,nullable = false)

    private String code;
    @Column(length = 500)
    private String displayValue;
    @Column(length = 500 , nullable = true)
    private  String longDescription;
    @Column(length = 10)
    private String fromDate;
    @Column(length = 10 ,nullable =true)
    private String toDate;

    private Long sortingPriority;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Long getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(Long sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}
