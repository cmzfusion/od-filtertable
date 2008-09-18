/**
 *  Copyright (C) Nick Ebbutt September 2009
 *
 *  This file is part of ObjectDefinitions Ltd. FilterTable.
 *  nick@objectdefinitions.com
 *  http://www.objectdefinitions.com/filtertable
 *
 *  FilterTable is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ObjectDefinitions Ltd. FilterTable is distributed in the hope that it will
 *  be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ObjectDefinitions Ltd. FilterTable.
 *  If not, see <http://www.gnu.org/licenses/>.
 */

package com.od.filtertable;

/**
 * Created by IntelliJ IDEA.
 * User: Nick Ebbutt
 * Date: 02-Sep-2008
 * Time: 16:22:27
 *
 * TableCell stores the current depth to which the cell has been indexed, the indexed
 * value is also stored so that we can remove the TableCell from the index when a row
 * delete takes place
 *
 * Important note :-
 * Since these go into sets it would be tempting to add equals and hashcode..
 * That would usually be a good idea, but in this case that temptation is from the dark side of the force
 * RowIndex is mutable, and will change on inserts and deletes, & hashcode by col alone will make the hashcode
 * implentation inefficient for tables with a lot of rows. A true jedi is happy with instance equality,
 * which is a design decision here
 */
class TableCell {

    private final MutableRowIndex mutableRowIndex;
    private final int col;
    private int indexedDepth;
    private Object value;

    public TableCell(MutableRowIndex row, int col) {
        this.mutableRowIndex = row;
        this.col = col;
    }

    public int getIndexedDepth() {
        return indexedDepth;
    }

    public void setIndexedDepth(int indexedDepth) {
        this.indexedDepth = indexedDepth;
    }

    public MutableRowIndex getMutableRowIndex() {
        return mutableRowIndex;
    }

    public int getRow() {
        return mutableRowIndex.index;
    }

    public int getCol() {
        return col;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isNullValue() {
        return value == null;
    }

    /**
     * Increase or decrease the row index for this table cell and all others which share its MutableRowIndex
     * (all other cells in the same row)
     * @param adjustment number of rows to add
     */
    public void adjustRowIndex(int adjustment) {
        mutableRowIndex.index = mutableRowIndex.index + adjustment;
    }

    public String toString() {
        return "cell: " + mutableRowIndex.index + "," + col;
    }
}
