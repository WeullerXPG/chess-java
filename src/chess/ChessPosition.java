package chess;

import boardgame.Position;

//CLASSE USADA PARA CONVERTER AS COORDENADAS DO XADREZ PARA OS NUMEROS DA MATRIZ
public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			//VERIFICA SE AS COORDENADAS(A1, B3, C2) SÃO VALIDAS 
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	//CONVERTER AS COORDENADAS DO XADREZ PARA OS NUMEROS DA MATRIZ
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	//FAZ O INVERSO
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
		//COLOCA O ESPAÇO VAZIO PARA MOSTRAR PARA O COMPILADOR Q É UMA CONCATENAÇÃO DE STRING
	}
}
