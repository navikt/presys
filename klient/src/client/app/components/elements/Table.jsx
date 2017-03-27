import React from 'react';

import TableRow from './TableRow';
import TableColumn from './TableColumn';

import styles from './table.less';

const Table = ({
  headerTextCodes,
  data,
  onMouseDownRow,
  onKeyDownRow,
  tabIndex,
  classNameTable,
}) => (
  <table className={`${styles.table} ${classNameTable}`}>
    <thead>
      <TableRow isHeader>
        {headerTextCodes.map(textCode =>
          <TableColumn key={textCode} textCode={textCode} />,
        )}
      </TableRow>
    </thead>
    <tbody>
      {data.map(row =>
        <TableRow key={row.key} id={row.key} model={row.model} onMouseDown={onMouseDownRow} onKeyDown={onKeyDownRow} tabIndex={tabIndex}>
          {row.columns.map(value =>
            <TableColumn key={value.key} value={value.value} />,
          )}
        </TableRow>,
      )}
    </tbody>
  </table>
);

Table.propTypes = {
  headerTextCodes: React.PropTypes.arrayOf(React.PropTypes.string.isRequired).isRequired,
  data: React.PropTypes.arrayOf(React.PropTypes.shape({
    key: React.PropTypes.number,
    model: React.PropTypes.shape(),
    columns: React.PropTypes.arrayOf(React.PropTypes.shape({
      key: React.PropTypes.string,
      value: React.PropTypes.any,
    })).isRequired,
  })).isRequired,
  onMouseDownRow: React.PropTypes.func,
  onKeyDownRow: React.PropTypes.func,
  tabIndex: React.PropTypes.string,
  classNameTable: React.PropTypes.string,
};

Table.defaultProps = {
  onMouseDownRow: null,
  onKeyDownRow: null,
  tabIndex: null,
  classNameTable: '',
};

export default Table;
