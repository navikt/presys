import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';


const PrettyJson = ({ data }) => <Row>
  <Column size={6}>
    <InfoTable>
      {Object.keys(data).map(key => <tr key={key}><td>{key}</td><td>{typeof (data[key]) === 'string' ? data[key] : JSON.stringify(data[key])}
      </td></tr>)}
    </InfoTable>
  </Column>
</Row>;

PrettyJson.propTypes = {
  data: React.PropTypes.shape({}).isRequired,
};


export default PrettyJson;
