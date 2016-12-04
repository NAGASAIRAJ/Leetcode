class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        result = []
        if len(s) == 1:
            if s in wordDict:
                result.append(s)
                return result
            else:
                return result
        else:
            return self.wordBreak2(s, 0, wordDict, "", result)
        
    def wordBreak2(self, inputStr, depth, wordDict, tmpRes, result):
    	"""
        :type inputStr: str
        :type depth: int
        :type wordDict: Set[str]
        :type tmpWord: str
        :type tmpRes: str
        :type wordDict: Set[str]
        :rtype result: List[str]
        """
        tmpWord = ""  
        for i in range(depth, len(inputStr)):
            tmpWord += inputStr[i]
            if tmpWord in wordDict:
                if i == (len(inputStr) - 1):
            		if not tmpRes:
            			result.append(tmpWord)
            		else:
                	    result.append(tmpRes[1:] + " " + tmpWord)
                	break
                else:
                	self.wordBreak2(inputStr, i+1, wordDict, tmpRes + " " + tmpWord, result)

        return result

if __name__ == "__main__":
    sol = Solution()
    print sol.wordBreak("a", {"a"})
    print sol.wordBreak("apple", {"pear","apple","peach"})
    print sol.wordBreak("catsanddog", {"cat", "cats", "and", "sand", "dog"})
    # print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})