package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
		//NÃO É PRECISO INICIAR, ATRIBUTO QUE NÃO É INICIADO RECEBER NULL AUTOMATICAMENTE
	}

	public Board getBoard() {
		return board;
	}
}
