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
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # compare later char with previous ones, stack is a tool with spacial order feature
        stack = Stack()
        for p in s:
            if p in "([{":
                stack.push(p)
            else:
                if stack.is_empty():
                    return False
                else:
                    if not self.is_matched(stack.peek(), p):
                        return False
                    else:
                        stack.pop()

        return stack.is_empty()

    def is_matched(self, left, right):
        leftStr = '({['
        rightStr = ')}]'
        return leftStr.index(left) == rightStr.index(right)

if __name__ == "__main__":
    sol = Solution()
    print sol.isValid('{{([][])}()}')
    print sol.isValid('[{()]')
