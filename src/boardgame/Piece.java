package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
		//N�O � PRECISO INICIAR, ATRIBUTO QUE N�O � INICIADO RECEBER NULL AUTOMATICAMENTE
	}

	public Board getBoard() {
		return board;
	}
}
