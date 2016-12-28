class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        w, h = len(board[0]), len(board)
        visited = [[0 for x in range(w)] for y in range(h)]
        for y in range(w):
            if board[0][y] == 'O':
                self.helper_func(0, y, visited, board)
            if board[h-1][y] == 'O':
                self.helper_func(h-1, y, visited, board)

        for x in range(h):
            if board[x][0] == 'O':
                self.helper_func(x, 0, visited, board)
            if board[x][w-1] == 'O':
                self.helper_func(x, w-1, visited, board)

        for x in range(h):
            for y in range(w):
                if board[x][y] == 'O':
                    board[x][y] = 'X'
                elif board[x][y] == 'P':
                    board[x][y] = 'O'

    def helper_func(self, x, y, visited, board):
        col = len(board[0])
        row = len(board)
        if x < 0 or y < 0 or x >= row or y >= col or visited[x][y] == 1 or board[x][y] == 'X':
            return
        else:
            visited[x][y] = 1
            board[x][y] = 'P'
            self.helper_func(x-1, y, visited, board)
            self.helper_func(x+1, y, visited, board)
            self.helper_func(x, y-1, visited, board)
            self.helper_func(x, y+1, visited, board)



if __name__ == "__main__":
    sol = Solution()
    board = [['X', 'X', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X']]
    print sol.solve(board)