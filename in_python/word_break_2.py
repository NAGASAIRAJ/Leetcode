class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        wordBreak2(s, 0, wordDict, "", "", result)
        
    def wordBreak2(inputStr, depth, wordDict, tmpWord, tmpRes, result):
        if (depth == inputStr.length)
            if (wordDict.contains(tmpWord))
                tmpRes.add(" ")
                tmpRes.add(tmpWord)
                result.add(tmpRes)
            return
          
        for (int i = depth; i < inputStr.length; i++)
            tmpWord.add(inputStr.charAt(depth))
            if (dict.contains(tmpWord))
                tmpRes.add(" ")
                tmpRes.add(tmpWord)
                wordBreak2(inputStr, i+1, wordDict, tmpWord, tmpRes, result)
                tmpRes.remove(tmpWord)
                tmpRes.remove(" ")