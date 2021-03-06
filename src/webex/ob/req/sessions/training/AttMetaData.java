package webex.ob.req.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttMetaData extends AbstractAtt {

    private String confName;

    private String agenda;

    private String description;

    public AttMetaData(String agenda, String confName, String description) {
        this.agenda = agenda;
        this.confName = confName;
        this.description = description;
    }

    public AttMetaData() {
        this.agenda = "defAgenda";
        this.confName = "defConfName";
        this.description = "defDescription";
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
