package atelier1.model;


import java.util.LinkedList;
import java.util.List;

import atelier1.nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de déplacement et de prise de la reine est différent de celui du pion
 */
public class QueenModel extends AbstractPieceModel {

	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
		super();
	}

	private Coord coord;
	private PieceSquareColor pieceColor;

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>();
		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int absColDistance = Math.abs(colDistance);
		int absLigDistance = Math.abs(ligDistance);
		if( absColDistance == absLigDistance ) {
			if (colDistance > 0 && ligDistance > 0) { //Pièce noire vers le bas
				char compteur = this.coord.getColonne();
				for (int i = this.coord.getLigne()+1; i < targetCoord.getLigne(); i++) {
					compteur +=1;
					coordsOnItinery.add(new Coord(compteur, i));
				}
			}
			else if(colDistance > 0 && ligDistance < 0) { // Pièce blanche vers le haut
				char compteur = this.coord.getColonne();
				for (int i = this.coord.getLigne()-1; i > targetCoord.getLigne(); i--) {
					compteur +=1;
					coordsOnItinery.add(new Coord(compteur, i));
				}
			}
			else if(colDistance < 0 && ligDistance < 0) { //
				char compteur = this.coord.getColonne();
				for (int i = this.coord.getLigne()-1; i > targetCoord.getLigne(); i--) {
					compteur --;
					coordsOnItinery.add(new Coord(compteur, i));
				}
			}
			else {
				char compteur = this.coord.getColonne();
				for (int i = this.coord.getLigne()+1; i < targetCoord.getLigne(); i++) {
					compteur --;
					coordsOnItinery.add(new Coord(compteur, i));
				}
			}
		}

		return coordsOnItinery;
	}


	
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);

		// Cas d'un déplacement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){

			// sans prise
			if (!isPieceToCapture) {
				if (Math.abs(colDistance) == 1) {
					ret = true;
				}
			}
			// avec prise
			else {
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " ["+pieceColor.toString().charAt(0) + coord + "]";
	}

}

