class Solution(object):
    def word_break(self, s, word_dict):
        """
        :type s: str
        :type word_dict: List[str]
        :rtype: List[str]
        """
        cur_word_set = set()
        result = []
        s_len = len(s)
        if s_len == 1:
            if s in word_dict:
                result.append(s)
                return result
            else:
                return result
        else:
            if self.check_char(s, s_len, word_dict):
                cache_buffer = {}
                return self.word_break_2(s, s_len, 0, cur_word_set, word_dict, "", "", cache_buffer, result)
                # return self.wordBreak3(s, s_len, 0, word_dict, "", "", result)
            else:
                return result
        
    def word_break_2(self, input_str, str_len, depth, cur_word_set, word_dict, tmp_word, tmp_res, cache_buffer, result):
        """
        :type input_str: str
        :type str_len: int
        :type depth: int
        :type cur_word_set Set[str]
        :type word_dict: Set[str]
        :type tmp_word: str
        :type tmp_res: str
        :type cache_buffer: dict
        :type word_dict: Set[str]
        :type result: List[str]
        :rtype result: List[str]
        """
        print "Processing depth: %d" % depth
        if input_str[depth:] in cache_buffer:
            print "Depth: %d" % depth
            print "later str: " + input_str[depth:]
            print "Cache: "
            for key in cache_buffer:
                print (key, ':', cache_buffer[key])
            if depth == (str_len - 1):
                if not tmp_res:
                    result.append(cache_buffer[input_str[depth:]])
                elif (tmp_res[1:] + " " + cache_buffer[input_str[depth:]]) not in result:
                    result.append(tmp_res[1:] + " " + cache_buffer[input_str[depth:]])
            else:
                print "cached, tmp_word: " + cache_buffer[input_str[depth:]]
                print "cached, tmp_res: " + tmp_res
                if not tmp_res:
                    tmp_result = cache_buffer[input_str[depth:]]
                else:
                    tmp_result = tmp_res[1:] + " " + cache_buffer[input_str[depth:]]
                if tmp_result not in result:
                    result.append(tmp_result)
                tmp_word = input_str[depth]
                if tmp_word in cur_word_set or tmp_word in word_dict:
                    cur_word_set.add(tmp_word)
                    if not tmp_res:
                        cache_buffer[input_str[0:depth + 1]] = tmp_word
                    else:
                        cache_buffer[input_str[0:depth + 1]] = (tmp_res[1:] + " " + tmp_word)
                    self.word_break_2(input_str, str_len, depth + 1, cur_word_set, word_dict, "", tmp_res + " "
                                      + tmp_word, cache_buffer, result)
                    del cache_buffer[input_str[0:depth + 1]]
                return result

        for i in range(depth, str_len):
            tmp_word += input_str[i]
            if tmp_word in cur_word_set or tmp_word in word_dict:
                if i == (str_len - 1):
                    print "Last step"
                    print "tmp_word: " + tmp_word
                    print "tmp_res: " + tmp_res
                    if not tmp_res:
                        if tmp_word not in result:
                            result.append(tmp_word)
                    elif (tmp_res[1:] + " " + tmp_word) not in result:
                        if (tmp_res[1:] + " " + tmp_word) not in result:
                            result.append(tmp_res[1:] + " " + tmp_word)
                    break
                else:
                    print "Step %d" % i
                    cur_word_set.add(tmp_word)
                    if not tmp_res:
                        cache_buffer[input_str[0:i+1]] = tmp_word
                    else:
                        cache_buffer[input_str[0:i+1]] = (tmp_res[1:] + " " + tmp_word)
                    print "Depth: %d" % depth
                    print "Before del, Cache: "
                    for key in cache_buffer:
                        print (key, ':', cache_buffer[key])
                    print "tmp_word: " + tmp_word
                    print "tmp_res: " + tmp_res
                    if tmp_word in word_dict:
                        self.word_break_2(input_str, str_len, i + 1, cur_word_set, word_dict, "", tmp_res + " "
                                          + tmp_word, cache_buffer, result)
                    else:
                        self.word_break_2(input_str, str_len, i + 1, cur_word_set, word_dict, tmp_word, tmp_res,
                                          cache_buffer, result)
                    print "tmp_word: " + tmp_word
                    print "tmp_res: " + tmp_res
                    del cache_buffer[input_str[0:i+1]]
                    print "Depth: %d" % depth
                    print "After del, Cache: "
                    for key in cache_buffer:
                        print (key, ':', cache_buffer[key])

        return result

    def word_break_3(self, input_str, str_len, depth, word_dict, tmp_word, tmp_res, result):
        """
        :type input_str: str
        :type str_len: int
        :type depth: int
        :type word_dict: Set[str]
        :type tmp_word: str
        :type tmp_res: str
        :type word_dict: Set[str]
        :type result: List[str]
        :rtype result: List[str]
        """
        print "Processing depth: %d" % depth
        for i in range(depth, str_len):
            tmp_word += input_str[i]
            if i == (str_len - 1):
                print "Last step"
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
                if tmp_word in word_dict:
                    if not tmp_res:
                        if tmp_word not in result:
                            result.append(tmp_word)
                    elif (tmp_res[1:] + " " + tmp_word) not in result:
                        if (tmp_res[1:] + " " + tmp_word) not in result:
                            result.append(tmp_res[1:] + " " + tmp_word)
                    break
            else:
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
                if tmp_word in word_dict:
                    self.word_break_3(input_str, str_len, i + 1, word_dict, "", tmp_res + " " + tmp_word, result)
                else:
                    self.word_break_3(input_str, str_len, i + 1, word_dict, tmp_word, tmp_res, result)
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
        return result

    def word_break_4(self, input_str, str_len, depth, word_dict, tmp_word, tmp_res, cache_buffer, result):
        """
        :type input_str: str
        :type str_len: int
        :type depth: int
        :type word_dict: Set[str]
        :type word_dict: Set[str]
        :type tmp_word: str
        :type tmp_res: str
        :type cache_buffer: dict
        :type result: List[str]
        :rtype result: List[str]
        """
        print "Processing depth: %d" % depth
        for i in range(depth, str_len):
            tmp_word += input_str[i]
            if i == (str_len - 1):
                print "Last step"
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
                if tmp_word in word_dict:
                    if not tmp_res:
                        if tmp_word not in result:
                            result.append(tmp_word)
                    elif (tmp_res[1:] + " " + tmp_word) not in result:
                        if (tmp_res[1:] + " " + tmp_word) not in result:
                            result.append(tmp_res[1:] + " " + tmp_word)
                    break
            else:
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
                later_str = input_str[depth:]
                if later_str in cache_buffer:
                    if not tmp_res:
                        tmp_result = cache_buffer[later_str]
                    else:
                        tmp_result = tmp_res[1:] + " " + cache_buffer[later_str]
                    if tmp_result not in result:
                        result.append(tmp_result)
                else:
                    if tmp_word in word_dict:
                        cache_buffer[input_str[0:i + 1]] = tmp_word
                        self.word_break_3(input_str, str_len, i + 1, word_dict, "", tmp_res + " " + tmp_word, result)
                    else:
                        cache_buffer[input_str[0:i + 1]] = (tmp_res[1:] + " " + tmp_word)
                        self.word_break_3(input_str, str_len, i + 1, word_dict, tmp_word, tmp_res, result)
                    del cache_buffer[input_str[0:i + 1]]
                print "tmp_word: " + tmp_word
                print "tmp_res: " + tmp_res
        return result

    @staticmethod
    def check_char(input_str, str_len, word_dict):
        char_set = set()
        for word in word_dict:
            for i in range(len(word)):
                char_set.add(word[i])

        for i in range(str_len):
            if input_str[i] in char_set:
                continue
            else:
                return False

        return True

if __name__ == "__main__":
    sol = Solution()
    # print sol.wordBreak("a", {"a"})
    # print sol.wordBreak("apple", {"pear","apple","peach"})
    # print sol.wordBreak("catsanddog", {"cat", "cats", "and", "sand", "dog"})
    print sol.word_break("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",
                         ["o", "b", "gbdfgiokkfnhl", "glibjohcmd", "bblcnhelanckn", "mflabckflflja", "mgda", "oheafhajjo", "cc", "cffalholojikojm", "haljiamccabh", "gjkdlonmhdacd", "ee", "bc", "mjj", "fdlmmbhij", "nn", "jiaaifedaihn", "nhligg", "hooaglldlei", "hajhebh", "ebijeeh", "me", "eibm", "ekkobhajgkem", "ohaofonhjakc", "n", "kjjogm", "mhn", "odcamjmodie", "edmagbkejiocacl", "kcbfnjialef", "lhifcohoe", "akgnn", "fbgakjhjb", "belggjekmn", "oinedhhnolc", "ddekcnag", "oneoakldakalb", "bodnokemafkhkhf", "dkefeddjdnab", "gflcngff", "fgnfmbcogmojgm", "ad", "jadhganf", "lojckbdfj", "gadkaoe", "jdam", "ljjndlnednnombl", "aggegbnngohbgga"])
    # print sol.wordBreak("bb", {"a","b","bbb","bbbb"})
    print sol.word_break("aaaaaaa", {"aaaa", "aa", "a"})
    # TODO: need debug when add cache
    # print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})
    # print sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"})
