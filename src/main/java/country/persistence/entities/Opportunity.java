package country.persistence.entities;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "oppo")
public class Opportunity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String opportunity;
	private String opportunity_owner;
	private String type;
	private String primary_csource;
	private String budget_confirmed;
	private String close_date;
	private String account_name;
	private String next_step;
	private String lead_source;
	private String probability;
	private String ROI_Analysis_Completed;
	private String Discovery_Completed;
	private String stage;
	private String amount;
	private String description;
	private String loss_reason;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpportunity() {
		return opportunity;
	}
	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}
	public String getOpportunity_owner() {
		return opportunity_owner;
	}
	public void setOpportunity_owner(String opportunity_owner) {
		this.opportunity_owner = opportunity_owner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrimary_csource() {
		return primary_csource;
	}
	public void setPrimary_csource(String primary_csource) {
		this.primary_csource = primary_csource;
	}
	public String getBudget_confirmed() {
		return budget_confirmed;
	}
	public void setBudget_confirmed(String budget_confirmed) {
		this.budget_confirmed = budget_confirmed;
	}
	public String getClose_date() {
		return close_date;
	}
	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getNext_step() {
		return next_step;
	}
	public void setNext_step(String next_step) {
		this.next_step = next_step;
	}
	public String getLead_source() {
		return lead_source;
	}
	public void setLead_source(String lead_source) {
		this.lead_source = lead_source;
	}
	public String getProbability() {
		return probability;
	}
	public void setProbability(String probability) {
		this.probability = probability;
	}
	public String getROI_Analysis_Completed() {
		return ROI_Analysis_Completed;
	}
	public void setROI_Analysis_Completed(String rOI_Analysis_Completed) {
		ROI_Analysis_Completed = rOI_Analysis_Completed;
	}
	public String getDiscovery_Completed() {
		return Discovery_Completed;
	}
	public void setDiscovery_Completed(String discovery_Completed) {
		Discovery_Completed = discovery_Completed;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLoss_reason() {
		return loss_reason;
	}
	public void setLoss_reason(String loss_reason) {
		this.loss_reason = loss_reason;
	}
	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", opportunity=" + opportunity + ", opportunity_owner="
				+ opportunity_owner + ", type=" + type + ", primary_csource=" + primary_csource + ", budget_confirmed="
				+ budget_confirmed + ", close_date=" + close_date + ", account_name=" + account_name + ", next_step="
				+ next_step + ", lead_source=" + lead_source + ", probability=" + probability
				+ ", ROI_Analysis_Completed=" + ROI_Analysis_Completed + ", Discovery_Completed=" + Discovery_Completed
				+ ", stage=" + stage + ", amount=" + amount + ", description=" + description + ", loss_reason="
				+ loss_reason + "]";
	}
}
