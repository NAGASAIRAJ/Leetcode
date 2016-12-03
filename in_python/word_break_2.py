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
          
        for i in range(depth, len(inputStr)):
            tmpWord += inputStr[i]
            # print tmpRes
            if tmpWord in wordDict:
            	if i == (len(inputStr) - 1):
                	result.append(tmpRes + " " + tmpWord)
                	break
                else:
            		# print tmpWord
                	self.wordBreak2(inputStr, i+1, wordDict, "", tmpRes + " " + tmpWord, result)
        # print result
        return result

if __name__ == "__main__":
	sol = Solution()
	print sol.wordBreak("catsanddog", {"cat", "cats", "and", "sand", "dog"})