package gov.va.escreening.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "battery")
@NamedQueries({
        @NamedQuery(name = "Battery.findAll", query = "SELECT b FROM Battery b") })
public class Battery implements Serializable, BatteryBaseProperties {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "battery_id")
    private Integer batteryId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "is_disabled")
    private boolean isDisabled;
    
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne
    @JoinTable(name="program_battery",
            joinColumns = { @JoinColumn(name = "battery_id", referencedColumnName = "battery_id") },
            inverseJoinColumns = { @JoinColumn(name = "program_id", referencedColumnName = "program_id") })
    private Program program;

    @Basic(optional = false)
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @OneToMany(mappedBy = "battery")
    private List<VeteranAssessment> veteranAssessmentList;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "battery_survey",
            joinColumns = { @JoinColumn(name = "battery_id", referencedColumnName = "battery_id") },
            inverseJoinColumns = { @JoinColumn(name = "survey_id", referencedColumnName = "survey_id") })
    private Set<Survey> surveys;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "battery_template",
            joinColumns = { @JoinColumn(name = "battery_id", referencedColumnName = "battery_id") },
            inverseJoinColumns = { @JoinColumn(name = "template_id", referencedColumnName = "template_id") })
    private Set<Template> templates;

    public Battery() {
    }

    public Battery(Integer batteryId) {
        this.batteryId = batteryId;
    }

    public Battery(Integer batteryId, Date dateCreated) {
        this.batteryId = batteryId;
        this.dateCreated = dateCreated;
    }

    public Integer getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(Integer batteryId) {
        this.batteryId = batteryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<VeteranAssessment> getVeteranAssessmentList() {
        return veteranAssessmentList;
    }

    public void setVeteranAssessmentList(List<VeteranAssessment> veteranAssessmentList) {
        this.veteranAssessmentList = veteranAssessmentList;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

    public Set<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(Set<Template> templates) {
        this.templates = templates;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batteryId != null ? batteryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Battery)) {
            return false;
        }
        Battery other = (Battery) object;
        if ((this.batteryId == null && other.batteryId != null)
                || (this.batteryId != null && !this.batteryId.equals(other.batteryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.va.escreening.entity.Battery[ batteryId=" + batteryId + ", name=" + name + " ]";
    }

//	public Program getProgram() {
//		return program;
//	}
//
//	public void setProgram(Program program) {
//		this.program = program;
//	}

}
