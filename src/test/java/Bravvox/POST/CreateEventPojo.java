package Bravvox.POST;

public class CreateEventPojo {


	private String title;
	private String subtitle;
	private String details;
	private String eventStartTime;
	private String eventEndTime;
	private String location;
	private Boolean requireAttendeeApproval;
	private Boolean isModerated;
	private Boolean isPostingOpen;
	private Boolean isPublic;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getEventStartTime() {
		return eventStartTime;
	}
	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}
	public String getEventEndTime() {
		return eventEndTime;
	}
	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getRequireAttendeeApproval() {
		return requireAttendeeApproval;
	}
	public void setRequireAttendeeApproval(Boolean requireAttendeeApproval) {
		this.requireAttendeeApproval = requireAttendeeApproval;
	}
	public Boolean getIsModerated() {
		return isModerated;
	}
	public void setIsModerated(Boolean isModerated) {
		this.isModerated = isModerated;
	}
	public Boolean getIsPostingOpen() {
		return isPostingOpen;
	}
	public void setIsPostingOpen(Boolean isPostingOpen) {
		this.isPostingOpen = isPostingOpen;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

}		


