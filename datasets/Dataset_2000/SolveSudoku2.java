public class SolveSudoku2 {
  public void solveSudoku(char[][] board) {
    solve(board,0,0);
  }
  boolean solve(char[][] board, int row, int col) {
    int[] next = getNextEmpty(board,row,col);
    if (next==null) return true;
    char[] possible = getPossibleValues(board,next[0],next[1]);
    if (possible==null) return false;
    for (char c:possible) {
      board[next[0]][next[1]]=c;
      if (solve(board,next[0],next[1])) return true;
      board[next[0]][next[1]]='.';
    }
    return false;
  }
  int[] getNextEmpty(char[][] board, int row, int col) {
    while (row<=8 && col<=8) {
      if (board[row][col]=='.') return new int[]{row,col};
      row = col==8? row+1:row;
      col = col==8? 0: col+1;
    }
    return null;
  }
  char[] getPossibleValues(char[][] board, int row, int col) {
    boolean[] s = new boolean[9];
    for (int i=0;i<9;i++) {
      if (board[row][i]!='.') s[board[row][i]-'1']=true;
      if (board[i][col]!='.') s[board[i][col]-'1']=true;
      char c = board[row/3*3+i/3][col/3*3+i%3];
      if (c!='.') s[c-'1']=true;
    }
    int num =0;
    for (int i=0;i<9;i++)
      if (!s[i]) num++;
    char[] r = new char[num];
    num = 0;
    for (int i=0;i<9;i++)
      if (!s[i]) r[num++]= (char)(i+'1');
    return r;
  }
}