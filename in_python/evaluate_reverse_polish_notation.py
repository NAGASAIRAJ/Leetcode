class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items)-1]

    def size(self):
        return len(self.items)

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        operand_stack = Stack()
        for c in tokens:
            if c in "+-*/":
                a = operand_stack.pop()
                b = operand_stack.pop()
                operand_stack.push(self.calculate(c, int(a), int(b)))
            else:
                operand_stack.push(c)

        return int(operand_stack.pop())

    def calculate(self, operator, a, b):
        if operator == "+":
            return a + b
        elif operator == "-":
            return b - a
        elif operator == "*":
            return a * b
        else:
            return b / a

if __name__ == "__main__":
    sol = Solution()
    print sol.evalRPN(["2", "1", "+", "3", "*"])
    print sol.evalRPN(["4", "13", "5", "/", "+"])
    print sol.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])