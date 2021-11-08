package atelier1.model;

import atelier1.nutsAndBolts.PieceSquareColor;

import java.util.List;

public abstract class AbstractPieceModel implements PieceModel {

    private Coord coord;
    private PieceSquareColor pieceColor;

    @Override
    public char getColonne()
    {
        return coord.getColonne();
    }

    @Override
    public int getLigne() {
        return coord.getLigne();
    }

    @Override
    public boolean hasThisCoord(Coord coord) {
        return this.coord.equals(coord);
    }

    @Override
    public void move(Coord coord) {
        this.coord = coord;
    }

    @Override
    public PieceSquareColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
        return false;
    }

    @Override
    public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
        return null;
    }
}
