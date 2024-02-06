package concerttours.facades;



public interface BandFacade {
    
    BandData getBand(String name);
    List<BandData> getBands();

}