import { useParams } from 'react-router-dom';

const PetInfo = () => {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const { id } = useParams<{ id: string }>();

  return (
    <div>
      <h1>Pet Information</h1>
    </div>
  );
}

export default PetInfo;