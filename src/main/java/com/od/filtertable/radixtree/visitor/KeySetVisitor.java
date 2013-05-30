package com.od.filtertable.radixtree.visitor;

import com.od.filtertable.radixtree.RadixTree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nick
 * Date: 22/05/13
 * Time: 17:53
 * 
 * Collect all the keys present in the suffix tree
 */
public class KeySetVisitor<V> implements SuffixTreeVisitor<V> {
    
    private StringBuilder sb = new StringBuilder();
    
    private List<String> allKeys = new ArrayList<String>();
    
    @Override
    public boolean visit(RadixTree<V> radixTree) {
        //add the label chars
        sb.append(radixTree.getLabel());
        if (radixTree.isTerminalNode()) {
            removeLastCharacter();
            allKeys.add(sb.toString());
        }
        return true;
    }

    @Override
    public void visitComplete(RadixTree<V> radixTree) {
        //remove the label chars
        int chars = radixTree.getLabelLength();
        if ( radixTree.isTerminalNode()) {
            chars--;
        }
        
        for (int c=0; c < chars; c++) {
            removeLastCharacter();
        }
    }

    public List<String> getLabels() {
        return allKeys;
    }

    private void removeLastCharacter() {
        sb.deleteCharAt(sb.length() - 1);
    }
}