import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main (String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("bands", Band.all());
      model.put("venues", Venue.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/bands/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/band-add.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/bands/new", (request, response) -> {
      String name = request.queryParams("name");
      if (!name.equals("") && !name.equals(" ")) {
        Band newBand = new Band(name);
        newBand.save();
      }
      response.redirect("/");
      return null;
    });

    get("/venues/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/venue-add.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/venues/new", (request, response) -> {
      String name = request.queryParams("name");
      if (!name.equals("") && !name.equals(" ")) {
        Venue newVenue = new Venue(name);
        newVenue.save();
      }

      response.redirect("/");
      return null;
    });

    get("/bands/:id", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Band band = Band.find(Integer.parseInt(request.params("id")));
      model.put("band", band);
      model.put("allVenues", Venue.all());
      model.put("template", "templates/band.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/bands/:id/add_venues", (request, response) -> {
      int bandId = Integer.parseInt(request.queryParams("band_id"));
      int venueId = Integer.parseInt(request.queryParams("venue_id"));
      Venue venue = Venue.find(venueId);
      Band band = Band.find(bandId);
      //Stops from adding multiples of same venue :)
      if (!band.getVenues().contains(venue)) {
        band.addVenue(venue);
      }
      response.redirect("/bands/" + bandId);
      return null;
    });

    get("/venues/:id", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Venue venue = Venue.find(Integer.parseInt(request.params("id")));
      model.put("venue", venue);
      model.put("allVenues", Venue.all());
      model.put("template", "templates/venue.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/bands/:id/edit", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Band band = Band.find(Integer.parseInt(request.params("id")));
      model.put("band", band);
      model.put("template", "templates/band-edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/bands/:id", (request,response) -> {
      int bandId = Integer.parseInt(request.params("id"));
      Band band = Band.find(bandId);
      String newName = request.queryParams("name");
      band.update(newName);
      response.redirect("/bands/" + bandId);
      return null;
    });

    post("/bands/:id/delete", (request,response) -> {
      int bandId = Integer.parseInt(request.params("id"));
      Band band = Band.find(bandId);
      band.delete();
      response.redirect("/");
      return null;
    });
  }
}
