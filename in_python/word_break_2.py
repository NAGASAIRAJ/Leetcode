class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        curWordSet = set()
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
                cacheBuffer = {}
                return self.wordBreak2(s, sLen, 0, curWordSet, wordDict, "", "", cacheBuffer, result)
                # return self.wordBreak3(s, sLen, 0, wordDict, "", "", result)
            else:
                return result
        
    def wordBreak2(self, inputStr, strLen, depth, curWordSet, wordDict, tmpWord, tmpRes, cacheBuffer, result):
        """
        :type inputStr: str
        :type strLen: int
        :type depth: int
        :type wordDict: Set[str]
        :type tmpWord: str
        :type tmpRes: str
        :type wordDict: Set[str]
        :rtype result: List[str]
        """
        print "Processing depth: %d" %(depth)
        if inputStr[depth:] in cacheBuffer:
            print "Depth: %d" %(depth)
            print "later str: " + inputStr[depth:]
            print "Cache: "
            for key in cacheBuffer:
                print (key, ':', cacheBuffer[key])
            if depth == (strLen - 1):
                if not tmpRes:
                    result.append(cacheBuffer[inputStr[depth:]])
                elif (tmpRes[1:] + " " + cacheBuffer[inputStr[depth:]]) not in result:
                    result.append(tmpRes[1:] + " " + cacheBuffer[inputStr[depth:]])
            else:
                print "cached, tmpWord: " + cacheBuffer[inputStr[depth:]]
                print "cached, tmpRes: " + tmpRes
                if not tmpRes:
                    tmpResult = cacheBuffer[inputStr[depth:]]
                else:
                    tmpResult = tmpRes[1:] + " " + cacheBuffer[inputStr[depth:]]
                if tmpResult not in result:
                    result.append(tmpResult)
                tmpWord = inputStr[depth]
                if tmpWord in curWordSet or tmpWord in wordDict:
                    curWordSet.add(tmpWord)
                    if not tmpRes:
                        cacheBuffer[inputStr[0:depth + 1]] = tmpWord
                    else:
                        cacheBuffer[inputStr[0:depth + 1]] = (tmpRes[1:] + " " + tmpWord)
                    self.wordBreak2(inputStr, strLen, depth + 1, curWordSet, wordDict, "", tmpRes + " " + tmpWord, cacheBuffer,
                                result)
                    del cacheBuffer[inputStr[0:depth + 1]]
                return result

        for i in range(depth, strLen):
            tmpWord += inputStr[i]
            if tmpWord in curWordSet or tmpWord in wordDict:
                if i == (strLen - 1):
                    print "Last step"
                    print "tmpWord: " + tmpWord
                    print "tmpRes: " + tmpRes
                    if not tmpRes:
                        if tmpWord not in result:
                            result.append(tmpWord)
                    elif (tmpRes[1:] + " " + tmpWord) not in result:
                        if (tmpRes[1:] + " " + tmpWord) not in result:
                            result.append(tmpRes[1:] + " " + tmpWord)
                    break
                else:
                    print "Step %d" %(i)
                    curWordSet.add(tmpWord)
                    if not tmpRes:
                        cacheBuffer[inputStr[0:i+1]] = tmpWord
                    else:
                        cacheBuffer[inputStr[0:i+1]] = (tmpRes[1:] + " " + tmpWord)
                    print "Depth: %d" % (depth)
                    print "Before del, Cache: "
                    for key in cacheBuffer:
                        print (key, ':', cacheBuffer[key])
                    print "tmpWord: " + tmpWord
                    print "tmpRes: " + tmpRes
                    if tmpWord in wordDict:
                        self.wordBreak2(inputStr, strLen, i+1, curWordSet, wordDict, "", tmpRes + " " + tmpWord, cacheBuffer, result)
                    else:
                        self.wordBreak2(inputStr, strLen, i + 1, curWordSet, wordDict, tmpWord, tmpRes, cacheBuffer, result)
                    print "tmpWord: " + tmpWord
                    print "tmpRes: " + tmpRes
                    del cacheBuffer[inputStr[0:i+1]]
                    print "Depth: %d" % (depth)
                    print "After del, Cache: "
                    for key in cacheBuffer:
                        print (key, ':', cacheBuffer[key])

        return result

    def wordBreak3(self, inputStr, strLen, depth, wordDict, tmpWord, tmpRes, result):
        """
        :type inputStr: str
        :type strLen: int
        :type depth: int
        :type wordDict: Set[str]
        :type tmpWord: str
        :type tmpRes: str
        :type wordDict: Set[str]
        :rtype result: List[str]
        """
        print "Processing depth: %d" %(depth)
        for i in range(depth, strLen):
            tmpWord += inputStr[i]
            if i == (strLen - 1):
                print "Last step"
                print "tmpWord: " + tmpWord
                print "tmpRes: " + tmpRes
                if tmpWord in wordDict:
                    if not tmpRes:
                        if tmpWord not in result:
                            result.append(tmpWord)
                    elif (tmpRes[1:] + " " + tmpWord) not in result:
                        if (tmpRes[1:] + " " + tmpWord) not in result:
                            result.append(tmpRes[1:] + " " + tmpWord)
                    break
            else:
                print "tmpWord: " + tmpWord
                print "tmpRes: " + tmpRes
                if tmpWord in wordDict:
                    self.wordBreak3(inputStr, strLen, i+1, wordDict, "", tmpRes + " " + tmpWord, result)
                else:
                    self.wordBreak3(inputStr, strLen, i + 1, wordDict, tmpWord, tmpRes, result)
                print "tmpWord: " + tmpWord
                print "tmpRes: " + tmpRes
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
    # print sol.wordBreak("a", {"a"})
    # print sol.wordBreak("apple", {"pear","apple","peach"})
    # print sol.wordBreak("catsanddog", {"cat", "cats", "and", "sand", "dog"})
    print sol.wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",["o","b","gbdfgiokkfnhl","glibjohcmd","bblcnhelanckn","mflabckflflja","mgda","oheafhajjo","cc","cffalholojikojm","haljiamccabh","gjkdlonmhdacd","ee","bc","mjj","fdlmmbhij","nn","jiaaifedaihn","nhligg","hooaglldlei","hajhebh","ebijeeh","me","eibm","ekkobhajgkem","ohaofonhjakc","n","kjjogm","mhn","odcamjmodie","edmagbkejiocacl","kcbfnjialef","lhifcohoe","akgnn","fbgakjhjb","belggjekmn","oinedhhnolc","ddekcnag","oneoakldakalb","bodnokemafkhkhf","dkefeddjdnab","gflcngff","fgnfmbcogmojgm","ad","jadhganf","lojckbdfj","gadkaoe","jdam","ljjndlnednnombl","aggegbnngohbgga"])
    # print sol.wordBreak("bb", {"a","b","bbb","bbbb"})
    print sol.wordBreak("aaaaaaa", {"aaaa","aa","a"})
    # TODO: need debug when add cache
    # print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})
    # print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"})