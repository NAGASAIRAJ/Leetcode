class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        result = []
        sLen = len(s)
        if sLen == 1:
            if s in wordDict:
                result.append(s)
                return result
            else:
                return result
        else:
            if self.checkChar(s, sLen, wordDict):
                return self.wordBreak2(s, sLen, 0, wordDict, "", result)
            else:
                return result
        
    def wordBreak2(self, inputStr, strLen, depth, wordDict, tmpRes, result):
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
        for i in range(depth, strLen):
            tmpWord += inputStr[i]
            if tmpWord in wordDict:
                if i == (strLen - 1):
            		if not tmpRes:
            			result.append(tmpWord)
            		else:
                	    result.append(tmpRes[1:] + " " + tmpWord)
                	break
                else:
                	self.wordBreak2(inputStr, strLen, i+1, wordDict, tmpRes + " " + tmpWord, result)

        return result

    def checkChar(self, inputStr, strLen, wordDict):
        charSet = set()
        for word in wordDict:
            for i in range(len(word)):
                charSet.add(word[i])

        for i in range(strLen):
            if inputStr[i] in charSet:
                continue
            else:
                return False

        return True

if __name__ == "__main__":
    sol = Solution()
    print sol.wordBreak("a", {"a"})
    print sol.wordBreak("apple", {"pear","apple","peach"})
    print sol.wordBreak("catsanddog", {"cat", "cats", "and", "sand", "dog"})
    print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})
    print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"})