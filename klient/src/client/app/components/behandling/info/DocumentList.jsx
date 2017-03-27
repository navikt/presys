import React from 'react';

import Table from 'elements/Table';
import DateTimeLabel from 'elements/DateTimeLabel';
import Label from 'elements/Label';

import styles from './documentList.less';

const headerTextCodes = [
  'DocumentList.Direction',
  'DocumentList.DocumentType',
  'DocumentList.DateTime',
];

const DocumentList = ({
  documents,
  selectDocumentCallback,
}) => {
  const tableData = documents.map(document => ({
    key: parseInt(document.dokumentId, 10),
    model: document,
    columns: [
        { key: `${document.dokumentId}-1`, value: '' },
        { key: `${document.dokumentId}-2`, value: document.dokumentType },
        { key: `${document.dokumentId}-3`, value: <DateTimeLabel dateTimeString={document.tidspunkt} /> },
    ],
  }));

  if (tableData.length === 0) {
    return <Label textCode="DocumentList.NoDocuments" className={styles.noDocuments} />;
  }

  return (
    <Table
      headerTextCodes={headerTextCodes}
      data={tableData}
      onMouseDownRow={selectDocumentCallback}
      onKeyDownRow={selectDocumentCallback}
      tabIndex="0"
    />
  );
};

DocumentList.propTypes = {
  documents: React.PropTypes.arrayOf(
    React.PropTypes.shape({
      journalpostId: React.PropTypes.string.isRequired,
      dokumentId: React.PropTypes.string.isRequired,
      dokumentType: React.PropTypes.string.isRequired,
      tidspunkt: React.PropTypes.string.isRequired,
    }).isRequired,
  ).isRequired,
  selectDocumentCallback: React.PropTypes.func.isRequired,
};

export default DocumentList;
