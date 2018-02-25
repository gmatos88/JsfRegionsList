package pe.edu.utp.jsfregionslist.beans;

import pe.edu.utp.jsfregionslist.models.HrService;
import pe.edu.utp.jsfregionslist.models.Region;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named                  //Combierte a Bean
@SessionScoped
public class RegionsBean implements Serializable {
    //Plural por afectar a las conexiones directas del DTO
    private HrService service;
    private Region region;

    public RegionsBean(){
        service = new HrService();
    }

    public List<Region> getRegions(){
        return service.findAllRegions();
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName(){
        return this.getRegion().getName();
    }

    public void setName(String name){
        this.getRegion().setName(name);
    }

    public String newRegion(){
        this.setRegion(new Region());
        return "success";
    }

    public String createRegion(){
        service.createRegion(this.getName());
        return "success";
    }
    public String editRegion(Region region){
        this.setRegion(region);
        return "success";
    }

    public String updateRegion() {
        service.updateRegion(this.getRegion());
        return "success";
    }

    public String deleteRegion(Region region){
        service.deleteRegion(region.getId());
        return "success";
    }
}
