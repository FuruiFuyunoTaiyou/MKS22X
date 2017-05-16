public interface Frontier{
    public void add(Location lugar);

    public Location next();

    public boolean hasNext();
}
