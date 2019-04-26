public class Puntos
{
private double lat;
private double lon;
private String id;

public Puntos(double lat, double lon, String id)
{
    this.lat = lat;
    this.lon = lon;
    this.id  = id;
}

public double getLat()
{
    return lat;
}

public void setLat(double lat)
{
    this.lat = lat;
}

public double getLon()
{
    return lon;
}

public void setLon(double lon)
{
    this.lon = lon;
}

public String getId()
{
    return id;
}

public void setId(String id)
{
    this.id = id;
}
}
