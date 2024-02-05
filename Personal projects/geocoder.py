ase sfp.NODE_TYPE_EXT_DECORATION:
                return 'def';
            case sfp.NODE_TYPE_EXT_PATTERN_RAW:
                if ( astWalker.canGoDown() ) { break; }
                return 'variable';
            case sfp.NODE_TYPE_EXT_PATTERN_COSMETIC:
            case sfp.NODE_TYPE_EXT_PATTERN_HTML:
                return 'variable';
            case sfp.NODE_TYPE_EXT_PATTERN_RESPONSEHEADER:
            case sfp.NODE_TYPE_EXT_PATTERN_SCRIPTLET:
                if ( astWalker.canGoDown() ) { break; }
                return 'variable';
            case sfp.NODE_TYPE_EXT_PATTERN_SCRIPTLET_TOKEN: {
                const token = astParser.getNodeString(currentWalkerNode);
                if ( scriptletNames.has(token) === false ) {
                    return 'warning';
                }
                return 'variable';
            }
            case sfp.NODE_TYPE_EXT_PATTERN_SCRIPTLET_ARG:
                return 'variable';
            case sfp.NODE_TYPE_NET_EXCEPTION:
                return 'tag strong';
            case sfp.NODE_TYPE_NET_PATTERN:
                if ( astWalker.canGoDown() ) { break; }
                if ( astParser.isRegexPattern() ) {
                    if ( astParser.getNodeFlags(currentWalkerNode, sfp.NODE_FLAG_PATTERN_UNTOKENIZABLE) !== 0 ) {
                        return 'variable warning';
                    }
                    return 'variable notice';
                }
                return 'variable';
            case sfp.NODE_TYPE_NET_PATTERN_PART:
                return 'variable';
            case sfp.NODE_TYPE_NET_PATTERN_PART_SPECIAL:
                return 'keyword strong';
            case sfp.NODE_TYPE_NET_PATTERN_PART_UNICODE:
                return 'variable unicode';
            case sfp.NODE_TYPE_NET_PATTERN_LEFT_HNANCHOR:
            case sfp.NODE_TYPE_NET_PATTERN_LEFT_ANCHOR:
            case sfp.NODE_TYPE_NET_PATTERN_RIGHT_ANCHOR:
            case sfp.NODE_TYPE_NET_OPTION_NAME_NOT:
                return 'keyword strong';
            case sfp.NODE_TYPE_NET_OPTIONS_ANCHOR:
            case sfp.NODE_TYPE_NET_OPTION_SEPARATOR:
                lastNetOptionType = 0;
                return 'def strong';
          