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
        {headerTextCodes.map(headerObject =>
          <TableColumn key={headerObject.textCode} textCode={headerObject.textCode} classNameTd={headerObject.classNameTd} />,
        )}
      </TableRow>
    </thead>
    <tbody>
      {data.map(row =>
        <TableRow key={row.key} id={row.key} model={row.model} onMouseDown={onMouseDownRow} onKeyDown={onKeyDownRow} tabIndex={tabIndex}>
          {row.columns.map(value =>
            <TableColumn key={value.key} value={value.value} classNameTd={value.classNameTd} />,
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
      classNameTd: React.PropTypes.string,
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
