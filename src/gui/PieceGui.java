package atelier1.gui;

import atelier1.nutsAndBolts.PieceSquareColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author francoise.perrin
 * 
 * Cette classe permet de donner une image aux pièces
 *
 */

public class PieceGui extends ImageView implements CheckersPieceGui {
	private PieceSquareColor color;

	public PieceGui(Image image, PieceSquareColor color) {
		setImage(image);
		this.color = color;

	}

	@Override
	public void promote(Image image) {

		this.setImage(image);

	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {

		if (this.color == gamerColor)
		{
			return true;
		}
		return false;
	}

}