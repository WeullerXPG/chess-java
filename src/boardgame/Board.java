package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			//QND CRIAR UM BOARD, VAI VERIFICAR SE NÃO FOI INICIADO COM 0 NO ROWS E COLUMNS
			//SE FOR INICIADO VAI LANÇAR A EXCEÇÃO
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	//ACESSAR UMA PEÇA EM DETERMINADA LINHA E COLUNA
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
		//SE ESSA POSIÇÃO NÃO EXISTIR, VAI LANÇAR A EXCEÇÃO
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	//VAI RETORNA A PEÇA Q TIVER NA MATRIZ, NESSA POSIÇÃO
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			//SE ESSA POSIÇÃO NÃO EXISTIR, VAI LANÇAR A EXCEÇÃO
				throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//PARA COLOCAR A PEÇA EM UMA POSIÇÃO
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			//SE JA TEM UMA PEÇA NESSA POSIÇÃO
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		//ATRIBUTO PIECES Q É UMA MATRIZ VAI RECEBER O PIECE NA POSIÇÃO INDICADA
		piece.position = position;
		//O POSITION DO PIECE VAI RECEBER O POSITION INDICADO
	}
	
	//METODO AUXILIAR PARA VERIFICAR SE A POSIÇÃO EXISTE
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	//VERIFICAR SE A POSIÇÃO EXISTE
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());	
	}
	
	//VERIFICAR SE TEM UMA PEÇA NESSA POSIÇÃO
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			//SE ESSA POSIÇÃO NÃO EXISTIR, VAI LANÇAR A EXCEÇÃO
				throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
			//CHAMOU O METODO PIECE Q RETORNA A PEÇA OU NULL SE ESTIVER VAZIO
	}
}
