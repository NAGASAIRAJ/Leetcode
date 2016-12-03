class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        result = []
        return self.wordBreak2(s, 0, wordDict, "", "", result)
        
    def wordBreak2(self, inputStr, depth, wordDict, tmpWord, tmpRes, result):
    	"""
        :type inputStr: str
        :type depth: int
        :type wordDict: Set[str]
        :type tmpWord: str
        :type tmpRes: str
        :type wordDict: Set[str]
        :rtype result: List[str]
        """
        if depth == len(inputStr):
            if tmpWord in wordDict:
                result.append(tmpRes + " " + tmpWord)
            return
          
        for i in range(depth, len(inputStr)):
            tmpWord += inputStr[depth]
            if tmpWord in wordDict:
                self.wordBreak2(inputStr, i+1, wordDict, tmpWord, tmpRes + " " + tmpWord, result)

        return result

if __name__ == "__main__":
	sol = Solution()
	print sol.wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"])